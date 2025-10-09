import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import activateUser from "./api";
import Alert from "@/shared/components/Alert";

function Activation() {
  const { token } = useParams();
  const [apiProgress, setApiProgress] = useState(false);
  const [error, setError] = useState(undefined);
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    async function activate() {
      try {
        setApiProgress(true);
        const response = await activateUser(token);
        const data = await response.json();
        setSuccess(response.data.message);
      } catch (error) {
        setError(error.response.data.message);
      } finally {
        setApiProgress(false);
      }
    }
    activate();
  }, [token]);

  return (
    <>
      {apiProgress && (
        <span
          className="spinner-border spinner-border-sm"
          aria-hidden="true"
        ></span>
      )}
      {error && <Alert styleType="danger">{error}</Alert>}
    </>
  );
}

export default Activation;
