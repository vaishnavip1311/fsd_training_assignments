import { BrowserRouter, Route, Routes } from "react-router-dom"
import AddUser from "./components/AddUser"
import EditUser from "./components/EditUser"
import UserList from "./components/UserList"

function App() {
  
  return (
    <div>
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<UserList/>}></Route>
        <Route path="/add-user" element={<AddUser />}></Route>
        <Route path="/edit-user/:uid" element={<EditUser />}></Route>
      </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
