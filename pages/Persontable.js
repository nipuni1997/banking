import React,{useEffect,useState} from 'react';

import { makeStyles } from '@material-ui/core/styles';
import NavBar from '../component/navbar';

import { Paper } from '@material-ui/core';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
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


function createData(Id, firstName, lastName, address,phoneNumber,bank,Delete,update) {
    return { Id, firstName, lastName, address,phoneNumber,bank,Delete,update};
  }
  //dummy
const rows = [
    createData(1, 'Nipuni','Withanage','Matugama','01124578','BOC', <button>Delete</button>,<button>Update</button>),
  
  ];
  

export default function Additem() {
  const classes = useStyles();
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);
  const [data,setData]=useState([]);

  useEffect(()=>{


      Axios.get("http://localhost:8080/getperson").then((response)=>{
          console.log(response.data);
          setData(response.data);


      }).catch((e)=>{
          console.log(e);
      })

  },[])
  return (
    <div className={classes.root}>
    <NavBar/>
  
<main className={classes.content}>
   <div className={classes.appBarSpacer} />
  
   <TableContainer component={Paper}>
      <Table className={classes.table} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell align="right">First Name</TableCell>
            <TableCell align="right">Last Name</TableCell>
            <TableCell align="right">Address</TableCell>
            <TableCell align="right">Phone no</TableCell>
            <TableCell align="right">Bank</TableCell>
            <TableCell align="right">Delete</TableCell>
            <TableCell align="right">Update</TableCell>
            
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((row) => (
            <TableRow key={row.name}>
              <TableCell component="th" scope="row">
                {row.Id}
              </TableCell>
              <TableCell align="right">{row.firstName}</TableCell>
              <TableCell align="right">{row.lastName}</TableCell>
              <TableCell align="right">{row.address}</TableCell>
              <TableCell align="right">{row.phoneNumber}</TableCell>
              <TableCell align="right">{row.bank}</TableCell>
              <TableCell align="right">{row.Delete}</TableCell>
              <TableCell align="right">{row.update}</TableCell>
             
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </main>
      </div>
  );
}
