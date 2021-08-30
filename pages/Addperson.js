import React, { useState } from 'react';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';
import NavBar from '../component/navbar';
import { Container } from '@material-ui/core';
import Button from '@material-ui/core/Button';
import PublishIcon from '@material-ui/icons/Publish';
import { Paper } from '@material-ui/core';
import Axios from 'axios';

import clsx from 'clsx';
const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    '& .MuiTextField-root': {
      margin: theme.spacing(1),
      width: '50ch',
      '& > *': {
        margin: theme.spacing(1),
      }
    },
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: '45ch',
  },
  appBarSpacer: theme.mixins.toolbar,
        content: {
            flexGrow: 1,
            height: '200vh',
            overflow: 'auto',
        },
        container: {
            paddingTop: theme.spacing(6),
            paddingBottom: theme.spacing(4),
            width:900,
          
            
        },
        paper: {
            padding: theme.spacing(2),
            display: 'flex',
            overflow: 'auto',
            flexDirection: 'column',
            
          },
          fixedHeight: {
            height: 600,
            width:900,
          },
          input: {
            display: 'none',
          },
          button: {
            margin: theme.spacing(3),
            position:'relative'
          },
          fixedHeightPaper:{
            height:1000
          },
}));

export default function Additem() {
  const classes = useStyles();
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);
  const [firstName,setfirstname]=useState('');
  const [lastName,setlastname]=useState('');
  const [address,setaddress]=useState('');
  const [phoneNumber,setphonenumber]=useState('');
  const [nic,setnic]=useState('');
  const [gender,setgender]=useState('');
  const [bank,setbank]=useState('');
  const [dob,setdob]=useState('');

  const addperson = ()=>{
    Axios.post('http://localhost:8080/addperson',JSON.stringify({
     
        firstName:firstName,
        lastName:lastName,
        address:address,
        phoneNumber:phoneNumber,
        nic:nic,
        gender:gender,
        bank:bank,
        dob:dob
  
   })).then(response => response.json())
   .then(response => {
     console.log(response)
   })
   .catch(error => alert("Error " + error))
   
  };



  return (
    <div className={classes.root}>
    <NavBar/>
  
<main className={classes.content}>
   <div className={classes.appBarSpacer} />
  
    <form className={classes.root} noValidate autoComplete="off">
    <Container minWidth="md" className={classes.container}>
        <Paper className={fixedHeightPaper}>
            <br></br>
            <h2 style={{color:'#42207A' , textAlign: "center"}}>Add a Person</h2>  
      <div className="paper" style={{position:'relative',bottom:'-3vw',top:'1vw', left:'5vw'}}>
        <TextField id="standard-read-only-input" label="First Name"  variant="outlined" onChange={(e)=>setfirstname(e)}/>
        <TextField id="standard-read-only-input" label="Last Name"  variant="outlined" onChange={(e)=>setlastname(e)}/>
        <TextField id="standard-read-only-input" label="Address"  variant="outlined" onChange={(e)=>setaddress(e)}/>
        <TextField id="standard-read-only-input" label="Date of Birth"  variant="outlined" onChange={(e)=>setdob(e)}/>
        <TextField id="standard-read-only-input" label="Phone Number"  variant="outlined" onChange={(e)=>setphonenumber(e)}/>
        <TextField id="standard-read-only-input" label="NIC"  variant="outlined"onChange={(e)=>setnic(e)}/> 
        <TextField id="standard-read-only-input" label="Gender"  variant="outlined" onChange={(e)=>setgender(e)}/>
        <TextField id="standard-read-only-input" label="Bank"  variant="outlined" onChange={(e)=>setbank(e)}/>
          </div>
          <Button style={{position:'relative',top:'3vw',width:'10vw',left:'25vw',background:'#C7F2F4'}} onClick={addperson}>Add</Button>
      
      
       
       
        
      </Paper>
      </Container>
    </form>
    
    </main>
      </div>
  );
}
