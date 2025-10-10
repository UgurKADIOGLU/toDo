import http from "../../../lib/http";



function getUsers(page=0) {
  return http.get(`/api/v1/users`,{params: {page, size:5}});
}

export default getUsers