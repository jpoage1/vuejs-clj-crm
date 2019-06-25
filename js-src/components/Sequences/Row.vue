<script>
export default {
  name: 'sequence',
  props: ['sequence'],
  methods: {
    deleteSequence (sequence) {
      this.$emit('delete', sequence)
    }
  },
  template: `
    <div class="Sequence">
      <p class="Sequence-Name">{{ sequence.name }}</p>
      <div class="Sequence-Delete"
          @click="deleteSequence(sequence)">-
      </div>
    </div>`
}
</script>

<style>
  .Sequence {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .Sequence-Name {
    width: 90%;
    background-color: white;
    border: 1px solid lightgrey;
    box-shadow: 1px 1px 1px lightgrey;
    padding: 12px;
    margin-right: 10px;
  }

  .Sequence-Delete {
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

  .Sequence-Delete:hover {
    box-shadow: none;
    margin-top: 1px;
    margin-left: 1px;
  }
</style>
