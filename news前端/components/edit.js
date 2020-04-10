var edit_template = `
  <div>
    <head1 :item="3"></head1>
    <br><br><br>
    <div class="container">
        <table class="table table-bordered table-striped" style="margin-top:20px;">
        <tr v-for="(item,index) in articles">
            <td v-on:click="selectitem(item.id)" >{{ item.title}}</td>
            <td><button type="button" class="btn btn-outline-primary" v-on:click="Delete(index)">删除</button></td>
            <td><button type="button" class="btn btn-outline-primary" v-on:click="Modify(item.id)">修改</button></td>
        </tr>
    </table>
    </div>
  </div>
  `
const edit = {
  data() {
    return {
      articles: '',
    }
  },
  methods: {
    selectitem(id) {
      router.push({
        path: 'detail',
        query: { id: id }
      })
    },
    Delete(index) {
      //数据库操作
      axios.delete(store.state.url + 'article/' + this.articles[index].id)
        .then(response => {
          console.log(response.data);
          this.articles.splice(index, 1);//从下标i开始删除1个元素：删除下标为i的元素
        })
        .catch(error => console.log(error));// 请求失败处理
    },
    Modify(id) {
      router.push({
        path:'editor',
        query: {id:id},
      })
    }
  },
  mounted() {
    //发送get请求
    axios.get(store.state.url + 'articles')
      .then(response => (this.articles = response.data))
      .catch(error => console.log(error));// 请求失败处理
  },
  template: edit_template
}
