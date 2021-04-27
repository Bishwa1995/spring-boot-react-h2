import React, { Component } from 'react'
import ApiService from "../../service/ApiService";

class EditUserComponent extends Component {

    constructor(props){
        super(props);
        this.state ={
            id: '',
            name: '',
            age: '',
            standard: '',
        }
        this.saveUser = this.saveUser.bind(this);
        this.loadUser = this.loadUser.bind(this);
        this.goBack = this.goBack.bind(this);
    }

    componentDidMount() {
        this.loadUser();
    }

    loadUser() {

        ApiService.fetchUserById(window.localStorage.getItem("userId"))
            .then((res) => {
                let user = res.data;
                this.setState({
                    id: user.id,
                    name: user.name,
                    age: user.age,
                    standard: user.standard,
                })
            });
               
            
    }
    goBack () {
        this.props.history.push('/students');
    }
    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    saveUser = (e) => {
        e.preventDefault();
        let id = window.localStorage.getItem("userId");
        let user = {id: id , name: this.state.name, age: this.state.age, standard: this.state.standard};
        ApiService.editUser(user)
            .then(res => {
                this.setState({message : 'User added successfully.'});
                this.props.history.push('/students');
            });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Edit Student</h2>
                <form>

                    <div className="form-group">
                        <label>Student Name:</label>
                        <input type="text" placeholder="student Name" name="name" className="form-control"  value={this.state.name} onChange={this.onChange}/>
                    </div>
                    <div className="form-group">
                        <label>Age:</label>
                        <input type="number" placeholder="age" name="age" className="form-control" value={this.state.age} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Standard:</label>
                        <input type="number" placeholder="Standard" name="standard" className="form-control" value={this.state.standard} onChange={this.onChange}/>
                    </div>

                    <button className="btn btn-success" onClick={this.saveUser}>Save</button>
                    <button className="btn btn-success" onClick={this.goBack} style = {{ margin: "10px"}}>Cancel</button>
                </form>
            </div>
        );
    }
}

export default EditUserComponent;