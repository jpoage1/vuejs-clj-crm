import regex from './regex'
const { absolute } = regex
export default {
  header: 'Configuration',
  name: 'Config',
  data: {
    form: {
      firstName: {
        id: 1,
        name: 'firstName',
        type: 'number',
        min: 0,
        max: 100,
        label: 'Hours for Full Time',
        value: 40,
        match: absolute
      },
      lastName: {
        id: 2,
        name: 'averageDeal',
        type: 'number',
        min: 0,
        label: 'Average Deal',
        value: 3500,
        match: absolute,
        prefix: '$'
      },
      team: { // Dollars Per Hour
        id: 3,
        name: 'productRate',
        type: 'number',
        min: 0,
        label: 'Product Rate',
        value: 150,
        match: absolute,
        prefix: '$'
      },
      role: { // Rate of conversion in decimal format
        id: 4,
        name: 'prospectToLead',
        type: 'number',
        min: 0,
        max: 100,
        label: 'Prospect to Lead',
        value: 10,
        match: absolute,
        suffix: '%'
      },
      rate: {
        id: 5,
        name: 'leadToQualified',
        type: 'number',
        min: 0,
        max: 100,
        label: 'Lead to Qualified',
        value: 10,
        match: absolute,
        suffix: '%'
      },
      hours: {
        id: 6,
        name: 'qualifiedToSale',
        type: 'number',
        min: 0,
        max: 100,
        label: 'Qualified to Sale',
        value: 10,
        match: absolute,
        suffix: '%'
      }
      created: {
        id: 6,
        name: 'qualifiedToSale',
        type: 'number',
        min: 0,
        max: 100,
        label: 'Qualified to Sale',
        value: 10,
        match: absolute,
        suffix: '%'
      }
    }
  }
}
