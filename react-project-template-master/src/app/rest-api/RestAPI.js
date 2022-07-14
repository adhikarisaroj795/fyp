import axios from "axios"

const login =(loginDto) => {
    return axios({
        url  : "http://localhost:8080/login",
        method :"POST",
        data : loginDto
    })
}

export default login;