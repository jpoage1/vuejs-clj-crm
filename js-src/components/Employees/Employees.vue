<script>
import EmployeesRow from './Employees/Row.vue'

export default {
  name: 'employees',
  components: {
    EmployeesRow
  },
  data () {
    return {
      employees: [
        {
          id: 1,
          name: 'clean the house'
        },
        {
          id: 2,
          name: 'buy milk'
        }
      ],
      employee: ''
    }
  },
  methods: {
    createNewEmployee () {
      // validate employee
      if (!this.employee) {
        alert('Please enter a employee!')
        return
      }

      const newId = Math.max.apply(null, this.employees.map(t => t.id)) + 1
      this.employees.push({ id: newId, name: this.employee })
      this.employee = ''
    },
    onDeleteEmployee (employee) {
      this.employees = this.employees.filter(row => row !== employee)
    }
  },
  template: `
    <div id="app">
    <router-view></router-view>
      <div class="Employees">
        <h1 class="Employees-Header">Employees</h1>
        <div class="Employees-Container">
          <div class="Employees-Content">
            <EmployeesRow v-for="employee in employees"
                      :employee="employee"
                      @delete="onDeleteEmployee"
                      :key="employee.id" />
          </div>
          <input type="text" v-model="employee" v-on:keyup.enter="createNewEmployee"/>
          <div class="Employees-Add" @click="createNewEmployee()">+</div>
        </div>
      </div>
    </div> `
}
</script>

<style>

  body {
    margin: 0;
    padding: 0;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    background: linear-gradient(#aeffae, #3d99ff);
    height: auto;
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-employees: center;
  }

  .Employees {
    text-align: center;
    border: 1px solid white;
    width: 80vw;
    height: auto;
    box-shadow: 2px 3px 15px rgba(0, 0, 0, 0.5);
    background: #f6f6f6;
    padding-bottom: 60px;
    margin: 40px auto;
  }

  .Employees-Header {
    color: black;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    font-weight: 400;
    text-transform: uppercase;
    margin: 70px auto 30px;
  }

  .Employees-Add {
    color: white;
    font-size: 2em;
    width: 0.5em;
    height: 0.5em;
    display: flex;
    justify-content: center;
    align-employees: center;
    padding: 15px;
    cursor: pointer;
    background: #73ff73;
    border-radius: 10px;
    box-shadow: 1px 1px 1px #47a947;
    margin: 20px auto 0;
  }

  .Employees-Add:hover {
    box-shadow: none;
    margin-top: 21px;
    margin-left: calc(auto + 1px);
  }

  .Employees-Container {
    width: 80%;
    margin: 0 auto;
  }

  input {
    width: 60%;
    padding: 10px;
    font-size: 1em;
    margin: 10px auto;
    box-shadow: 1px 3px 20px 0px rgba(0, 0, 0, 0.3)
  }
</style>
