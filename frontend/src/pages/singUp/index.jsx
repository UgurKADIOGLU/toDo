import React, { useEffect, useState } from "react";
import Input from "@/componets/input";
import singUp from "./api";
import { useTranslation } from "react-i18next";
import { Alert } from "bootstrap/dist/js/bootstrap.bundle.min";


function SingUp() {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordRepeat, setPasswordRepeat] = useState("");
  const [apiProgress, setApiProgress] = useState(false);
  const [message, setMessage] = useState();
  const [errors, setErrors] = useState({});
  const{t}=useTranslation();

   const onSubmit = async (event) => {
    event.preventDefault();
    setApiProgress(true);
    setMessage();
    try {
      const response = await singUp({
        username,
        email,
        password,
        passwordRepeat,
      });
      
      setMessage(response.data.message);
      
      console.log(message);
    } catch (err) {
   if(err.response?.data && err.response.data.status === 400){
    setErrors(err.response.data.validationErrors);
   }else{
    setErrors(err.response?.data.message);
   }
      
      console.log(errors);
    } finally {
      setApiProgress(false);
    }
  };

 useEffect(() => {
    setErrors(prevErrors => ({
      ...prevErrors,
      username: undefined
    }));
}, [username]);

useEffect(() => {
    setErrors(prevErrors => ({
      ...prevErrors,
      email: undefined
    }));
}, [email]);

  return (
    <form onSubmit={onSubmit}>
      <div className="card container " style={{ maxWidth: "500px" }}>
        <div className="card-header">
          <h1 className="text-center">{t("singup")}</h1>
        </div>
        <div className="card-body">
          <Input
            label={t("userName")}
            id="username"
            onChange={(e) => setUsername(e.target.value)}
            errors={errors.username} 
          />
          
          <Input
            label={t("email")}
            id="email"
            onChange={(e) => setEmail(e.target.value)}
            errors={errors.email} 
          />
          <Input
            label={t("password")}
            id="password"
            type="password"
            onChange={(e) => setPassword(e.target.value)}
            //errors={errors} 
          />
          <Input 
            label={t("confirmPassword")} 
            id="rePassword"
            type="password"
            onChange={(e) => setPasswordRepeat(e.target.value)}
            //errors={errors} 
          />
        </div>
        <div className="card-footer text-center">
          {password !== passwordRepeat && (
            <div className="alert alert-danger">{t("passwordMismatch")}</div>
          )}
          {message && <Alert styleType="success">{message}</Alert>}
          <button
            type="submit"
            className="btn btn-primary"
            disabled={
              apiProgress ||
              password !== passwordRepeat ||
              
              !email ||
              !password ||
              !passwordRepeat
            }
          >
            {apiProgress && 
              <span
                className="spinner-border spinner-border-sm"
                role="status"
                aria-hidden="true"
              ></span>
             }
            {t("singup")}
          </button>
        </div>
        
      </div>
     
    </form>
  );
}

export default SingUp;
