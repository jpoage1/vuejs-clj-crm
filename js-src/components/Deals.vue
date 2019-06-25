<script>
import DealsRow from './Deals/Row.vue'

export default {
  name: 'deals',
  components: {
    DealsRow
  },
  data () {
    return {
      deals: [
        {
          id: 1,
          name: 'clean the house'
        },
        {
          id: 2,
          name: 'buy milk'
        }
      ],
      deal: ''
    }
  },
  methods: {
    createNewDeal () {
      // validate deal
      if (!this.deal) {
        alert('Please enter a deal!')
        return
      }

      const newId = Math.max.apply(null, this.deals.map(t => t.id)) + 1
      this.deals.push({ id: newId, name: this.deal })
      this.deal = ''
    },
    onDeleteDeal (deal) {
      this.deals = this.deals.filter(row => row !== deal)
    }
  },
  template: `
    <div id="app">
    <router-view></router-view>
      <div class="Deals">
        <h1 class="Deals-Header">Deals</h1>
        <div class="Deals-Container">
          <div class="Deals-Content">
            <DealsRow v-for="deal in deals"
                      :deal="deal"
                      @delete="onDeleteDeal"
                      :key="deal.id" />
          </div>
          <input type="text" v-model="deal" v-on:keyup.enter="createNewDeal"/>
          <div class="Deals-Add" @click="createNewDeal()">+</div>
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
    align-deals: center;
  }

  .Deals {
    text-align: center;
    border: 1px solid white;
    width: 80vw;
    height: auto;
    box-shadow: 2px 3px 15px rgba(0, 0, 0, 0.5);
    background: #f6f6f6;
    padding-bottom: 60px;
    margin: 40px auto;
  }

  .Deals-Header {
    color: black;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    font-weight: 400;
    text-transform: uppercase;
    margin: 70px auto 30px;
  }

  .Deals-Add {
    color: white;
    font-size: 2em;
    width: 0.5em;
    height: 0.5em;
    display: flex;
    justify-content: center;
    align-deals: center;
    padding: 15px;
    cursor: pointer;
    background: #73ff73;
    border-radius: 10px;
    box-shadow: 1px 1px 1px #47a947;
    margin: 20px auto 0;
  }

  .Deals-Add:hover {
    box-shadow: none;
    margin-top: 21px;
    margin-left: calc(auto + 1px);
  }

  .Deals-Container {
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
