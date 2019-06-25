<script>
import Contact from './Contacts/Row.vue'

export default {
  name: 'contacts',
  components: {
    Contact
  },
  data () {
    return {
      contacts: [
        {
          id: 1,
          name: 'clean the house'
        },
        {
          id: 2,
          name: 'buy milk'
        }
      ],
      contact: ''
    }
  },
  methods: {
    createNewContact () {
      // validate contact
      if (!this.contact) {
        alert('Please enter a contact!')
        return
      }

      const newId = Math.max.apply(null, this.contacts.map(t => t.id)) + 1
      this.contacts.push({ id: newId, name: this.contact })
      this.contact = ''
    },
    onDeleteContact (contact) {
      this.contacts = this.contacts.filter(row => row !== contact)
    }
  },
  template: `
    <div id="app">
    <router-view></router-view>
      <div class="Contacts">
        <h1 class="Contacts-Header">Contacts</h1>
        <div class="Contacts-Container">
          <div class="Contacts-Content">
            <ContactsRow v-for="contact in contacts"
                      :contact="contact"
                      @delete="onDeleteContact"
                      :key="contact.id" />
          </div>
          <input type="text" v-model="contact" v-on:keyup.enter="createNewContact"/>
          <div class="Contacts-Add" @click="createNewContact()">+</div>
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
    align-contacts: center;
  }

  .Contacts {
    text-align: center;
    border: 1px solid white;
    width: 80vw;
    height: auto;
    box-shadow: 2px 3px 15px rgba(0, 0, 0, 0.5);
    background: #f6f6f6;
    padding-bottom: 60px;
    margin: 40px auto;
  }

  .Contacts-Header {
    color: black;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    font-weight: 400;
    text-transform: uppercase;
    margin: 70px auto 30px;
  }

  .Contacts-Add {
    color: white;
    font-size: 2em;
    width: 0.5em;
    height: 0.5em;
    display: flex;
    justify-content: center;
    align-contacts: center;
    padding: 15px;
    cursor: pointer;
    background: #73ff73;
    border-radius: 10px;
    box-shadow: 1px 1px 1px #47a947;
    margin: 20px auto 0;
  }

  .Contacts-Add:hover {
    box-shadow: none;
    margin-top: 21px;
    margin-left: calc(auto + 1px);
  }

  .Contacts-Container {
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
