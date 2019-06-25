<script>
import CompaniesRow from './Companies/Row.vue'

export default {
  name: 'companies',
  components: {
    CompaniesRow
  },
  data () {
    return {
      companies: [
        {
          id: 1,
          name: 'clean the house'
        },
        {
          id: 2,
          name: 'buy milk'
        }
      ],
      company: ''
    }
  },
  methods: {
    createNewCompany () {
      // validate company
      if (!this.company) {
        alert('Please enter a company!')
        return
      }

      const newId = Math.max.apply(null, this.companies.map(t => t.id)) + 1
      this.companies.push({ id: newId, name: this.company })
      this.company = ''
    },
    onDeleteCompany (company) {
      this.companies = this.companies.filter(row => row !== company)
    }
  },
  template: `
    <div id="app">
    <router-view></router-view>
      <div class="Companies">
        <h1 class="Companies-Header">Companies</h1>
        <div class="Companies-Container">
          <div class="Companies-Content">
            <CompaniesRow v-for="company in companies"
                      :company="company"
                      @delete="onDeleteCompany"
                      :key="company.id" />
          </div>
          <input type="text" v-model="company" v-on:keyup.enter="createNewCompany"/>
          <div class="Companies-Add" @click="createNewCompany()">+</div>
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
    align-companies: center;
  }

  .Companies {
    text-align: center;
    border: 1px solid white;
    width: 80vw;
    height: auto;
    box-shadow: 2px 3px 15px rgba(0, 0, 0, 0.5);
    background: #f6f6f6;
    padding-bottom: 60px;
    margin: 40px auto;
  }

  .Companies-Header {
    color: black;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    font-weight: 400;
    text-transform: uppercase;
    margin: 70px auto 30px;
  }

  .Companies-Add {
    color: white;
    font-size: 2em;
    width: 0.5em;
    height: 0.5em;
    display: flex;
    justify-content: center;
    align-companies: center;
    padding: 15px;
    cursor: pointer;
    background: #73ff73;
    border-radius: 10px;
    box-shadow: 1px 1px 1px #47a947;
    margin: 20px auto 0;
  }

  .Companies-Add:hover {
    box-shadow: none;
    margin-top: 21px;
    margin-left: calc(auto + 1px);
  }

  .Companies-Container {
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
