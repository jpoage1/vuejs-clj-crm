
import config from '../components/config'
import Menu from '../components/Menu'
import icp from '../components/icp'
import icps from '../components/icps.js'
import employees from '../components/employees'
import Form from '../components/Form'

let i = 0
const links = [
  {
    id: ++i,
    path: '/Config',
    name: 'Config',
    component: Form,
    props: config
  },
  {
    id: ++i,
    path: '/Employees',
    name: 'Employees',
    component: Menu,
    props: employees
  },
  {
    id: ++i,
    path: '/ICPs',
    name: 'ICPs',
    component: Menu,
    props: icps
  },
  {
    id: ++i,
    path: '/Contacts',
    name: 'Contacts',
    component: Menu,
    props: config
  },
  {
    id: ++i,
    path: '/Companies',
    name: 'Companies',
    component: Menu,
    props: config
  },
  {
    id: ++i,
    path: '/Deals',
    name: 'Deals',
    component: Menu,
    props: config
  },
  {
    id: ++i,
    path: '/Sequences',
    name: 'Sequences',
    component: Menu,
    props: config
  }
]
export default {
  mode: 'history',
  routes: [
    {
      id: ++i,
      path: '/',
      name: 'Home',
      component: Menu,
      props: {
        mainMenu: true,
        name: 'Home',
        header: 'Home',
        data: {
          links: links
        }
      }
    },
    ...links,
    {
      id: ++i,
      path: '/Employees/:id',
      name: 'Employee',
      component: Form,
      props: icp
    },
    {
      path: '/ICP/:id',
      name: 'ICP',
      component: Form,
      props: icp
    },
    {
      id: ++i,
      path: '/Contact/:id',
      name: 'Contact',
      component: Form,
      props: icp
    },
    {
      id: ++i,
      path: '/Company/:id',
      name: 'Company',
      component: Form,
      props: icp
    },
    {
      id: ++i,
      path: '/Deal/:id',
      name: 'Deal',
      component: Form,
      props: icp
    },
    {
      id: ++i,
      path: '/Sequence/:id',
      name: 'Sequence',
      component: Form,
      props: icp
    }
  ]
}
