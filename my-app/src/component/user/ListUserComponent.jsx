import React, { Component } from 'react'
import ApiService from "../../service/ApiService";

class ListUserComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            users: [],
            message: null
        }
        this.deleteUser = this.deleteUser.bind(this);
        this.editUser = this.editUser.bind(this);
        this.addUser = this.addUser.bind(this);
        this.reloadUserList = this.reloadUserList.bind(this);
    }

    componentDidMount() {
        this.reloadUserList();
    }

    reloadUserList() {
        ApiService.fetchUsers()
            .then((res) => {
                this.setState({users: res.data})
            });
    }

    deleteUser(userId) {
        if(window.confirm("Once deleted the changes can not be undone")){
            ApiService.deleteUser(userId)
           .then(res => {
               this.setState({message : 'User deleted successfully.'});
               this.setState({users: this.state.users.filter(user => user.id !== userId)});
           })
        }
        

    }

    editUser(id) {
        window.localStorage.setItem("userId", id);
        this.props.history.push('/edit-student');
    }

    addUser() {
        window.localStorage.removeItem("userId");
        this.props.history.push('/add-student');
    }

    render() {
        const mystyle = {
            width: "100px"
           
          };
        return (
            <div>
                <button className="btn btn-success" style={mystyle} onClick={() => this.addUser()}> Add Student</button>
                <div><br /></div>
                <table className="table table-bordered" style={{padding:"50px"}}>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Student Name</th>
                            <th>Age</th>
                            <th>Class</th>
                            <th>Edit</th>
                            <th>Delete</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.users.map(
                        user =>
                                    <tr key={user.id}>
                                        <td>{user.id}</td>
                                        <td>{user.name}</td>
                                        <td>{user.age}</td>
                                        <td>{user.standard}</td>
                                        <td>
                                            <button className="btn btn-success" onClick={() => this.editUser(user.id)} > Edit</button>
                                        </td>
                                        <td>
                                        <button className="btn btn-danger" onClick={() => this.deleteUser(user.id)}> Delete</button>
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>

            </div>
        );
    }

}

export default ListUserComponent;