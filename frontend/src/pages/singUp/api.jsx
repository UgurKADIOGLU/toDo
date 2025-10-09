import http from "../../lib/http";


function singUp(body) {
  return http.post("/api/v1/users", body);
}

export default singUp