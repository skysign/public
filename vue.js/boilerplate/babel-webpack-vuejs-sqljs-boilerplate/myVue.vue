<template>
    <div id="app">
        <h2>sql.js example with Vue.js</h2>
        <div v-for="value in values" :value-data="value">
            <p>value id/title: {{value[0]}}/{{value[1]}} </p>
        </div>

        <h2>input/member variable with Vue.js</h2>
        <div>
            <input v-model="msg">
            <p>msg: {{msg}}</p>
            <p v-model="helloMsg">helloMsg: {{helloMsg}}</p>
            <p>computed msg: {{computedMsg}}</p>
        </div>
        <hr>

        <h2>Calling method in Vue.js from button by using click event</h2>
        <button @click="myClick">click to call method</button>
        <hr>

        <h2>Used module list for this boilerplage</h2>
        <ul>
            <li>babel-core</li>
            <li>babel-loader</li>
            <li>babel-plugin-transform-class-properties</li>
            <li>babel-plugin-transform-decorators-legacy</li>
            <li>babel-preset-env</li>
            <li>cross-env</li>
            <li>css-loader</li>
            <li>vue</li>
            <li>vue-class-component</li>
            <li>vue-loader</li>
            <li>vue-property-decorator</li>
            <li>vue-template-compiler</li>
            <li>webpack</li>
            <li>webpack-dev-server</li>
        </ul>
        <hr>
        <h2>My Vue.js boilerplates</h2>
            <ul>
              <li><a href="https://github.com/skysign/public/tree/master/vue.js/boilerplate" target="_blank">https://github.com/skysign/public/tree/master/vue.js/boilerplate</a></li>
            </ul>
        <hr>
        <h2>github and blog</h2>
        <ul>
            <li><a href="https://github.com/skysign" target="_blank">https://github.com/skysign</a></li>
        </ul>
        <ul>
            <li><a href="http://skysign.tistory.com/" target="_blank">http://skysign.tistory.com/</a></li>
        </ul>
    </div>
</template>

<script>
//import Vue from 'vue'
//import Component from 'vue-class-component'
import { Component, Emit, Inject, Model, Prop, Provide, Vue, Watch } from 'vue-property-decorator'

@Component
export default class MyVue extends Vue {
    // initial data
    msg = "msg default"
    // use prop values for initial data
    helloMsg = "don't changed as per msg is updated : " + this.msg;
    values = [];
    mDB = null;
    mDBFile = null;

    setDBFile(db) {
        console.log("begin setDB");
        this.mDBFile = db;
        var db = new SQL.Database(this.mDBFile);
        this.mDB = db;
        console.log("end setDB");
    }

    testsql() {
        var sql = "select * from mytable";
        var rlt = this.mDB.exec(sql);
        this.values = rlt[0].values;
    }

    MyVue () {
        console.log("MyVue consturctor, it doesn't work");
    }

    mounted() {
        console.log("begin mounted it works");
        var msgOfMyMethod = this.myMethod();
        console.log(msgOfMyMethod);
        console.log("end mounted");
    }

    get computedMsg () {
        console.log("get computedMsg");
        return 'computed ' + this.msg
    }

    myMethod() {
        console.log("myMethod is called");
        return "myMethod msg";
    }

    myClick () {
        alert('myClick: ' + this.msg)
    }

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>