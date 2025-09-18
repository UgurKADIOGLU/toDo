import React, { useState } from "react";
import Input from "../../componets/input";
import axios from 'axios';

function SingUp() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordRepeat, setPasswordRepeat] = useState("");

  const onSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post("/api/v1/users", {
        name,
        email,
        password,
        passwordRepeat,
      });
      console.log(response);
    } catch (err) {
      console.log(err);
    }finally {
      console.log("Request completed");
    }
  };

  return (
    <form onSubmit={onSubmit}>
      <div className="card container " style={{ maxWidth: "500px" }}>
        <div className="card-header">
          <h1 className="text-center">Kayıt</h1>
        </div>
        <div className="card-body">
          <blockquote className="blockquote mb-3">
            <Input
              label="Kullanici Adi"
              id="name"
              onChange={(e) => setName(e.target.value)}
            />
            <Input
              label="E Posta"
              id="email"
              onChange={(e) => setEmail(e.target.value)}
            />
            <Input
              label="Sifre"
              id="password"
              type="password"
              onChange={(e) => setPassword(e.target.value)}
            />
            <Input
              label="Sifre Tekrar"
              id="rePassword"
              type="password"
              onChange={(e) => setPasswordRepeat(e.target.value)}
            />

            <footer className="text-center">
              <button
                type="submit"
                className="btn btn-primary mb-3"
                disabled={
                  password !== passwordRepeat ||
                  !name ||
                  !email ||
                  !password ||
                  !passwordRepeat
                }
              >
                Kayit Ol
              </button>
            </footer>
          </blockquote>
        </div>
      </div>
    </form>
  );
}

export default SingUp;
