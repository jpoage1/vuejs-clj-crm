<script>
export default {
  name: 'company',
  props: ['company'],
  methods: {
    deleteCompany (company) {
      this.$emit('delete', company)
    }
  },
  template: `
    <div class="Company">
      <p class="Company-Name">{{ company.name }}</p>
      <div class="Company-Delete"
          @click="deleteCompany(company)">-
      </div>
    </div>`
}
</script>

<style>
  .Company {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .Company-Name {
    width: 90%;
    background-color: white;
    border: 1px solid lightgrey;
    box-shadow: 1px 1px 1px lightgrey;
    padding: 12px;
    margin-right: 10px;
  }

  .Company-Delete {
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

  .Company-Delete:hover {
    box-shadow: none;
    margin-top: 1px;
    margin-left: 1px;
  }
</style>
