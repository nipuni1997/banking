import React,{useEffect,useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import Navbar from '../component/navbar';
import Axios from 'axios';
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
  

function createData(BankId, BankName, Delete, Update) {
  return { BankId, BankName, Delete, Update };
}
// Dummy
const rows = [
  createData(1, 'BOC', <button>Delete</button>,<button>Update</button>),

];

export default function DenseTable() {
  const classes = useStyles();
  const [data,setData]=useState([]);

  useEffect(()=>{


      Axios.get("http://192.168.8.103:3001/getData").then((response)=>{
          console.log(response.data);
          setData(response.data);


      }).catch((e)=>{
          console.log(e);
      })

  },[])


  return (
    <div className={classes.root}>
    <Navbar/>
    <main className={classes.content}>
   <div className={classes.appBarSpacer} />

    <TableContainer component={Paper}>
      <Table className={classes.table} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell>Bank ID</TableCell>
            <TableCell align="right">Bank Name</TableCell>
            <TableCell align="right">Delete</TableCell>
            <TableCell align="right">Update</TableCell>
            
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((row) => (
            <TableRow key={row.name}>
              <TableCell component="th" scope="row">
                {row.BankId}
              </TableCell>
              <TableCell align="right">{row.BankName}</TableCell>
              <TableCell align="right">{row.Delete}</TableCell>
              <TableCell align="right">{row.Update}</TableCell>
             
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </main>
      </div>
      
        
  );
}
