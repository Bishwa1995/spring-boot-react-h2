import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import ListUserComponent from "./user/ListUserComponent";
import AddUserComponent from "./user/AddUserComponent";
import EditUserComponent from "./user/EditUserComponent";
import React from "react";

const AppRouter = () => {
    return(
        <div>
            <Router>
                <div className="col-md-6">
                    <h1 className="text-center" style={style}>Student List</h1>
                    <Switch>
                        <Route path="/" exact component={ListUserComponent} />
                        <Route path="/students" component={ListUserComponent} />
                        <Route path="/add-student" component={AddUserComponent} />
                        <Route path="/edit-student" component={EditUserComponent} />
                    </Switch>
                </div>
            </Router>
        </div>
    )
}

const style = {
    color: 'red',
    margin: '10px'
}

export default AppRouter;