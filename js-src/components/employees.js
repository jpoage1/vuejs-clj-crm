let i = 150
export default {
  header: 'Employees',
  name: 'Employees',
  data: {
    linkComponent: 'Employee',
    links: [
      {
        id: ++i,
        name: 'Employee'
      },
      {
        id: ++i,
        name: 'Employee2'
      }
    ]
  }
}
