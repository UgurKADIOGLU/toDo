import http from "../../lib/http";



function activateUser(token) {
  return http.patch(`/api/v1/users/${token}/active`);
}

export default activateUser