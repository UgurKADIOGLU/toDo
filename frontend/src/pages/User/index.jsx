import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import getUser from './api';

function User() {
  const { id } = useParams();
  const [user, setUser] = useState({});
  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    async function fetchUser() {
      setLoading(true);
      try {
        const response = await getUser(id);
        setUser(response.data);
        setError(undefined);
      } catch (err) {
        setError(err.response?.data?.message || 'User not found');
        console.log(err);
      } finally {
        setLoading(false);
      }
    }
    fetchUser();
  }, [id]);

  return (
    <div className="card">
      {error && <div className="alert alert-danger">{error}</div>}
      {loading && <div className="spinner-border"></div>}
      {user && (
        <div className="card-body">
          <h3>{user.username}</h3>
          <p>{user.email}</p>
        </div>
      )}
    </div>
  );
}

export default User