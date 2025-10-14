import http from "../../lib/http";



export default function getUser(id) {
  return http.get(`/api/v1/users/${id}`);
}
