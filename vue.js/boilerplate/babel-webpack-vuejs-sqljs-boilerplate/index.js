import Vue from 'vue'
import MyVue from './myVue.vue'

// index.js
console.log("my index.js")

function load_db_from_http(path,success) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", path, true);
        xhr.responseType = "arraybuffer";
        xhr.onload = function() {
            var data = new Uint8Array(xhr.response);
            var arr = new Array();
            for(var i = 0; i != data.length; ++i) arr[i] = String.fromCharCode(data[i]);
            success(arr.join(""));
        };
        xhr.send();
};

var myVueInstance = new MyVue({
    el: '#app',
    components: {
        MyVue
    }
})

load_db_from_http("http://localhost:8080/sqlitedb/mytest.db",
	function(myDBData){
		if (null == myDBData) {
			console.log("db data is failed to load from http");
			return;
		}
		console.log("db data is loaded from http");
        test_sql(myDBData);
        myVueInstance.setDBFile(myDBData);
        myVueInstance.testsql()
	}
);


function test_sql(myDBData) {
	var db = new SQL.Database(myDBData);
	var rlt = db.exec("select * from mytable");
	console.log(rlt);
	
	var values = rlt[0].values;
	console.log(values);
	
	for (var i = 0; i < values.length; ++i) {
		console.log(values[i][1] + " " + values[i][1]);
	}
}
