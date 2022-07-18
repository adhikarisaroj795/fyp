import axios from "axios"
import { getToken } from "../auth/AuthUtil"
//import { getToken } from "../auth/AuthUtil"

const login =(loginDto) => {
    return axios({
        url  : "http://localhost:8080/login",
        method :"POST",
        data : loginDto
    })
}
const addUser =(userDto) => {
    return axios({
        url  : "http://localhost:8080/login",
        method :"POST",
        data : userDto
    })
}
const editUser =(userDto) => {
    return axios({
        url  : "http://localhost:8080/users",
        method :"PUT",
        data : userDto,
        headers :{
            Authorization: getToken()
        }
    })
}
const getUser =(id) => {
    return axios({
        url  : "http://localhost:8080/users/"+id,
        method :"GET",
    
        headers :{
            Authorization: getToken()
        }
    })
}

const deleteUser =(id) => {
    return axios({
        url  : "http://localhost:8080/users/"+id,
        method :"DELETE",
    
        headers :{
            Authorization: getToken()
        }
    })
}



const listUser =() => {
    return axios({
        url  : "http://localhost:8080/login",
        method :"GET",
        headers :{

            Authorization: getToken()
        }
            
            

        })
        
}

export default login;
export {addUser, listUser, editUser, getUser, deleteUser}
    