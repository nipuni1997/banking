import React from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';

import DashboardIcon from '@material-ui/icons/Dashboard';
import {Link} from 'react-router-dom';
import PeopleIcon from '@material-ui/icons/People';


export const mainListItems = (
  <div>
    <ListItem button component={Link} to= "/">
      <ListItemIcon>
        <DashboardIcon />
      </ListItemIcon>
      <ListItemText primary="Bank List" />
    </ListItem>
    <ListItem button component={Link} to= "/Persontable">
      <ListItemIcon>
      <PeopleIcon />
      </ListItemIcon>
      <ListItemText primary="Customer List" />
    </ListItem>
    <ListItem button component={Link} to = "/AddPerson">
      <ListItemIcon>
        <PeopleIcon />
      </ListItemIcon>
      <ListItemText primary="Add Customer" />
    </ListItem>
    <ListItem button component={Link} to="/AddBank">
      <ListItemIcon>
      <DashboardIcon />
      </ListItemIcon>
      <ListItemText primary="Add Bank" />
    </ListItem>
   
  </div>
);

