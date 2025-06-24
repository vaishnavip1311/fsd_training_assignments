import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function EditUser() {

    const params = useParams();
    const TOKEN = 'fc2744127d4f5a75c844ae56098c3de6e6efb6513d9f0246b260fffe35ec1e3f';
    const navigate = useNavigate();
    const [user, setUser] = useState({});
    let [msg, setMsg] = useState("");
    let [name, setName] = useState("");
    let [email, setEmail] = useState("");
    let [gender, setGender] = useState("");
    let [status, setStatus] = useState("");


    useEffect(() => {
        const getUser = async () => {
            try {
                const response = await axios.get(
                    `https://gorest.co.in/public/v2/users/${params.uid}`,
                    {
                    headers: {
                        Authorization: `Bearer ${TOKEN}`,
                        'Content-Type': 'application/json',
                    }
                }
                );
                const userData = response.data;
                setUser(userData);
                setName(userData.name);
                setEmail(userData.email);
                setGender(userData.gender);
                setStatus(userData.status);
            } catch (error) {
                console.log(error);
            }
        };
        getUser();
    }, []);

    const handleUpdate = async () => {
        try {
            await axios.put(
                `https://gorest.co.in/public/v2/users/${params.uid}`,
                {
                    'name': name,
                    'email': email,
                    'gender': gender,
                    'status': status
                },
                {
                    headers: {
                        Authorization: `Bearer ${TOKEN}`,
                        'Content-Type': 'application/json',
                    }
                }
            );
            setMsg("User updated successfully");
        } catch (error) {
            console.log(error);
            setMsg("Failed to update user");
        }
    };

    return (
        <div className="container-fluid">
            <div className="row">
                <div className="col-md-8">
                    <div className="card">
                        <div className="card-header" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                            <h1 style={{ flexGrow: 1, textAlign: 'center', margin: 0 }}>Enter User Details To Update</h1>
                            <button className="btn btn-primary" onClick={() => navigate("/")}>Return To User List</button>
                        </div>
                        <div className="card-body">
                            <div>
                                {
                                    msg !== "" ? <div className="mb-4">
                                        <div className="alert alert-primary">
                                            {msg}
                                        </div>
                                    </div> : null
                                }
                            </div>
                            <div className="mb-3">
                                <label>Enter Name:</label>
                                <input type="text" className="form-control" value={name} onChange={e => setName(e.target.value)}></input>
                            </div>
                            <div className="mb-3">
                                <label>Enter Email:</label>
                                <input type="text" className="form-control" value={email} onChange={e => setEmail(e.target.value)}></input>
                            </div>
                            <div className="mb-3">
                                <label>Select Gender:</label>
                                <select name="gender" className="form-select"  value={gender} onChange={e => setGender(e.target.value)}>
                                    <option value="">--Select--</option>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
                                </select>
                            </div>
                            <div className="mb-3">
                                <label>Select status:</label>
                                <select name="status" className="form-select" value={status} onChange={e => setStatus(e.target.value)}>
                                    <option value="active">Active</option>
                                    <option value="inactive">Inactive</option>
                                </select>
                            </div>
                            <div className="mb-4">
                                <button className="btn btn-primary" onClick={() => handleUpdate()}>Update User</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    )
}

export default EditUser;