import React, { useState, useEffect } from 'react'

import { CForm, CFormInput, CFormLabel, CButton } from '@coreui/react'

import { useNavigate } from 'react-router-dom'
import { useParams } from 'react-router-dom'
import { editUser, getUser } from '../rest-api/RestAPI'

const EditUser = () => {
  let { id } = useParams()

  const navigate = useNavigate()
  const [user, setUser] = useState({})

  useEffect(() => {
    loadUser(id)
  }, [])

  const handleChange = (event) => {
    const { name, value } = event.target
    setUser((prevState) => ({
      ...prevState,
      [name]: value,
    }))
    console.log(user.email)
  }

  const handleSubmit = () => {
    editUser(user)
      .then((data) => {
        console.log('User added successfully')
        navigate('/users/list')
      })
      .catch((error) => {})
  }

  const loadUser = (id) => {
    getUser(id)
      .then((res) => res.data)
      .then((rows) => {
        setUser(rows)
      })
      .catch((error) => {
        console.log(error)
      })
  }
  return (
    <div>
      <CForm>
        <div div className="w-50 p-3">
          <CFormLabel>Email address</CFormLabel>
          <CFormInput
            type="text"
            name="username"
            value={user.username}
            onChange={handleChange}
            placeholder="John"
          />
          <CFormLabel>Password</CFormLabel>
          <CFormInput
            type="password"
            name="password"
            value={user.password}
            onChange={handleChange}
          />
          <CFormLabel>Name</CFormLabel>
          <CFormInput
            type="text"
            name="name"
            value={user.name}
            onChange={handleChange}
            placeholder="Martin"
          />
        </div>
      </CForm>
      <CButton color="primary" onClick={handleSubmit}>
        Add
      </CButton>
    </div>
  )
}

export default EditUser