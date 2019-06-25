import regex from './regex'

const { absolute, text, boolean } = regex

let i = 0

export default {
  name: 'ICP',
  header: 'Ideal Customer Profile',
  data: {
    form: {
      technology: {
        id: ++i,
        name: 'technology',
        type: 'text',
        label: 'Technology',
        value: '',
        match: text
      },
      industry: {
        id: ++i,
        name: 'industry',
        type: 'text',
        label: 'Industry',
        value: '',
        match: text
      },
      geography: {
        id: ++i,
        name: 'geography',
        type: 'text',
        label: 'Geography',
        value: '',
        match: text
      },
      hiring: {
        id: ++i,
        name: 'hiring',
        type: 'checkbox',
        label: 'Hiring',
        value: 0,
        match: boolean
      },
      triggers: {
        id: ++i,
        name: 'triggers',
        type: 'text',
        label: 'Triggers',
        value: '',
        match: text
      },
      employees: {
        id: ++i,
        name: 'employees',
        type: 'number',
        min: 0,
        label: 'Number of Employees',
        value: 0,
        match: absolute
      },
      revenue: {
        id: ++i,
        name: 'revenue',
        type: 'number',
        min: 0,
        label: 'Revenue',
        value: 0,
        match: absolute,
        prefix: '$'
      }
    }
  }
}
