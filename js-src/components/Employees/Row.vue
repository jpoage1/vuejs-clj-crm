<script>
export default {
  name: 'employee',
  props: ['employee'],
  methods: {
    deleteEmployee (employee) {
      this.$emit('delete', employee)
    }
  },
  template: `
    <div class="Employee">
      <router-link tag="p" :to="{ name: employee.name, params: { id: employee.id } }" class="Employee-Name">
        <a class="Link-Action">{{ employee.name }}</a>
      </router-link>
    </div>`
}
</script>

<style>
  .Employee {
    display: flex;
    justify-content: center;
    align-employees: center;
  }

  .Employee-Name {
    width: 90%;
    background-color: white;
    border: 1px solid lightgrey;
    box-shadow: 1px 1px 1px lightgrey;
    padding: 12px;
    margin-right: 10px;
  }

  .Employee-Delete {
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

  .Employee-Delete:hover {
    box-shadow: none;
    margin-top: 1px;
    margin-left: 1px;
  }
</style>
