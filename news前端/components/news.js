var news_template = `
  <div>
    <head1 :item="1"></head1>
    <br><br><br>
    <div class="container">
    <div class="media border p-3" v-for="item in articles" v-on:click="selectitem(item.id)">
        <div class="media-left">
        <img :src="url+item.thumbnail" class="img-thumbnail" style="width:150px">
        </div>

        <div class="media-body">
          <p>{{item.title}}</p>
          <p>发表日期：{{item.cdate}}</p>
      </div>
    </div>
  </div>
  `
const news = {
  data() {
    return {
      articles: '',
      url:store.state.url,
    }
  },
  methods: {
    selectitem(id) {
      router.push({
        path: 'detail',
        query: { id: id }
      })
    }
  },
  mounted() {
    //发送get请求
    axios.get(store.state.url+'articles')
      .then(response => this.articles = response.data)
      .catch(error => console.log(error));// 请求失败处理
  },

  


  template: news_template
}
