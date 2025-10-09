import http from "../../lib/http";



function getUsers() {
  return http.get(`/api/v1/users`);
}

export default getUsers