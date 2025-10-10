import React, { useCallback, useEffect, useState } from "react";
import getUsers from "./api";

function UserList() {
  const [users, setUsers] = useState({
    content: [],
    last: false,
    first: false,
    number: 0,
  });
  const [error, setError] = useState();
  const [apiProgress, setApiProgress] = useState(false);

  const fetch = useCallback(async (page) => {
    setApiProgress(true);
    try {
      const { data } = await getUsers(page);
      setUsers(data);
      setError(undefined);
    } catch (err) {
      setError(err.response?.data?.message || 'Unexpected error occurred');
      console.log(err);
    } finally {
      setApiProgress(false);
    }
  }, []);

  useEffect(() => {
    fetch();
  }, [fetch]);
  console.log(users);
  
  return (
    <div className="card">
      {error && (
        <div className="alert alert-danger">
          {error}
        </div>
      )}
      <div className="card-header">
        <h3 className="mb-0">Users</h3>
      </div>
      <div className="card-body">
        <div className="list-group">
          {users.content.map((user) => (
            <div key={user.id} className="list-group-item list-group-item-action">
              <h5 className="mb-1">{user.username}</h5>
              <small className="text-muted">{user.email}</small>
            </div>
          ))}
        </div>
      </div>
      <div className="card-footer d-flex justify-content-between">
        {!users.first && (
          <button 
            className="btn btn-primary" 
            onClick={() => fetch(users.number - 1)}
            disabled={apiProgress}
          >
           
            Previous
          </button>
          
        )}
        {apiProgress && (
              <span className="spinner-border spinner-border-sm me-1"></span>
            )}
        {!users.last && (
          <button 
            className="btn btn-primary" 
            onClick={() => fetch(users.number + 1)}
            disabled={apiProgress}
          >
            
            Next
          </button>
        )}
      </div>
    </div>
  );
}

export default UserList;
