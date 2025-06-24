import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import EditUser from "./EditUser";

function UserList() {

    const TOKEN = 'fc2744127d4f5a75c844ae56098c3de6e6efb6513d9f0246b260fffe35ec1e3f';
    let[users, setUsers] = useState([]);
    let[msg, setMsg] = useState("");

    useEffect(()=>{
        const getUsers= async()=>{

            try {
                const response = await axios.get('https://gorest.co.in/public/v2/users',
                    {
                        headers: {
                            Authorization: `Bearer ${TOKEN}`,
                            'Content-Type': 'application/json',
                        }
                    }
                );
                //console.log(response.data)
                setUsers(response.data)
            } catch (error) {
                console.log(error);
            }
        }
        getUsers();
    },[])

    const handleDelete =async(userId)=>{
        try {
            if (window.confirm('Are you sure to delete this user?'))
            {
                await axios.delete(`https://gorest.co.in/public/v2/users/${userId}`,
                {
                        headers: {
                            Authorization: `Bearer ${TOKEN}`,
                            'Content-Type': 'application/json',
                        }
                    }
            );
            let temp = [...users];
            temp = temp.filter(u=> u.id !== userId);
            setUsers(temp);
            setMsg("User deleted with id "+userId);
            }
        } catch (error) {
            setMsg("Could not delete resource");
        }
    }

    return(
        <div className="card ">
            <div className="card-header" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                <h1 style={{ flexGrow: 1, textAlign: 'center', margin: 0 }}>User List</h1>
                <Link className="btn btn-primary" to="/add-user">AddUser</Link>
            </div>
            <div className="card-body d-flex justify-content-center">
                {
                msg !== "" ? <div className="row">
                    <div className="col-lg-12 alert alert-primary">
                         {msg}
                    </div>
                </div> : ""
            }
            </div>
            <div className="card-body d-flex justify-content-center">
                 
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    {
                       users.map((user,index)=>(
                        <tr key={user.id}>
                                <th scope="row">{user.id}</th>
                                <td>{user.name}</td>
                                <td>{user.email}</td>
                                <td>{user.gender}</td>
                                <td>{user.status}</td>
                                <td>
                                    <Link className="btn btn-secondary me-2" to={`/edit-user/${user.id}`}>Edit</Link>
                                    <button className="btn btn-danger" onClick={()=>(handleDelete(user.id))}>Delete</button>
                                </td>
                            </tr>
                       ))
                    }
                </tbody>
            </table>
        </div>
        </div>
    )
}

export default UserList;