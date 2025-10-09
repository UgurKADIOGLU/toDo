import React, { useEffect, useState } from 'react'
import getUsers from './api'

function Home() {
  const [users, setUsers] = useState([])
  
  useEffect(() => {
    async function fetchUsers() {
      const response = await getUsers()
      setUsers(response.data)
    } 
    fetchUsers()
  }, [])

  return (
    <div >
      
        <h3>Users</h3>
     
     
        
          {users.map(user => (
            <div key={user.id} >
              <h5 className="mb-1">{user.username}</h5>
              <small className="text-muted">{user.email}</small>
            </div>
          ))}
       
      
    </div>
  )
}

export default Home