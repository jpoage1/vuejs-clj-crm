<script>
export default {
  name: 'contact',
  props: ['contact'],
  methods: {
    deleteContact (contact) {
      this.$emit('delete', contact)
    }
  },
  template: `
    <div class="Contact">
      <p class="Contact-Name">{{ contact.name }}</p>
      <div class="Contact-Delete"
          @click="deleteContact(contact)">-
      </div>
    </div>`
}
</script>

<style>
  .Contact {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .Contact-Name {
    width: 90%;
    background-color: white;
    border: 1px solid lightgrey;
    box-shadow: 1px 1px 1px lightgrey;
    padding: 12px;
    margin-right: 10px;
  }

  .Contact-Delete {
    width: 20px;
    padding: 5px;
    height: 20px;
    cursor: pointer;
    background: #ff7373;
    border-radius: 10px;
    box-shadow: 1px 1px 1px #c70202;
    color: white;
    font-size: 18px;
    margin-right: 5px;
  }

  .Contact-Delete:hover {
    box-shadow: none;
    margin-top: 1px;
    margin-left: 1px;
  }
</style>
