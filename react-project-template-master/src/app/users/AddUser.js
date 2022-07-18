import { CForm, CFormLabel, CFormInput, CButton } from "@coreui/react";
import React from "react";
import {useState} from 'react';
import {useNavigate} from 'react-router-dom';
import { addUser } from "../rest-api/RestAPI";

const AddUser =()=>
{
    const navigate = useNavigate();
    const [user, setUser] = useState
    ({
        username: '',
        password:''
    })
    const handleChange = (e) =>
    {
        const { name, value} = e.target
        setUser(prevState => ({
            ...prevState,
            [name]:value,
        }))
    }
    const handleSubmit = () =>
    {
      addUser(user).then(data=>
        {
            console.log("/User Added Successfully");
            navigate("/dashboard")

        }).catch(error=>{
            console.log(error);
            console.log("Error when adding user");
        })
    }
    
    return(
        <div>
            <CForm>
                <div className="mb-3">
                    <CFormLabel> Email address</CFormLabel>
                    <CFormInput
                    type="email"
                    placeholder="name@example.com"
                    name="username"
                    value={user.username}
                    onChange={handleChange}
                    />                    
                </div>
                <div className="mb-3">
                    <CFormLabel> Password</CFormLabel>
                    <CFormInput
                    type="password"
                    placeholder="password"
                    name="password"
                    value={user.password}
                    onChange={handleChange}
                    />                    
                </div>
                <div className="mb-3">
                    <CFormLabel> Name</CFormLabel>
                    <CFormInput
                    type="text"
                    placeholder="Cena"
                    name="fullName"
                    value={user.fullName}
                    onChange={handleChange}
                    />                    
                </div>
                <div className="mb-3">
                    <CFormLabel> Address</CFormLabel>
                    <CFormInput
                    type="text"
                    placeholder="kathmandu"
                    name="address"
                    value={user.address}
                    onChange={handleChange}
                    />                    
                </div>
<CButton color="primary" onClick={handleSubmit}> Submit</CButton>
            </CForm>
        </div>
    )
}


export default AddUser