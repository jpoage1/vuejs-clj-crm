let i = 0
export default {
  header: 'Ideal Customer Profiles',
  name: 'ICPs',
  data: {
    linkComponent: 'ICP',
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
