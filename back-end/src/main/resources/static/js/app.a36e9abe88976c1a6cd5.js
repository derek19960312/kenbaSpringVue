webpackJsonp([1],{"4Uwr":function(e,t,n){e.exports=n.p+"img/logo.b66bfe2.jpg"},"9M+g":function(e,t){},"9sE3":function(e,t){},Jmt5:function(e,t){},NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=n("7+uW"),i={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var s=n("VU/8")({name:"App"},i,!1,function(e){n("gsu9")},null,null).exports,a=n("/ocq"),o={name:"SiteMap",data:function(){return{name:"KenBa Kitchen"}},methods:{axiosTest:function(e){this.axios.post("http://localhost:8080/recipe",{name:"Apple",count:10}).then(function(e){console.log(e.data)}).catch(function(e){console.log(e)}),this.axios.put("http://localhost:8080/recipe/4",{name:"App",count:8})}}},l={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"sitemap"},[r("h1",[e._v(e._s(e.name))]),e._v(" "),r("b-img",{attrs:{src:n("4Uwr"),fluid:""}}),e._v(" "),r("div",{staticClass:"w-100"}),e._v(" "),r("div",{staticClass:"mt-3 mb-3"},[r("b-button",{attrs:{to:{name:"InsertResume"}}},[e._v("InsertResume")]),e._v(" "),r("b-button",{attrs:{to:{name:"ReadResume"}}},[e._v("ReadResume")])],1),e._v(" "),r("b-button",{on:{click:e.axiosTest}},[e._v("AXIOSTEST")])],1)},staticRenderFns:[]};var u=n("VU/8")(o,l,!1,function(e){n("kFIL")},"data-v-4e84b92c",null).exports,m=n("mvHQ"),c=n.n(m),d={render:function(){var e=this.$createElement,t=this._self._c||e;return this.isStyle()?t("div",[t("b-table",{attrs:{bordered:"",items:this.items,fields:this.fields}})],1):t("div",[t("b-table",{attrs:{borderless:"",items:this.items,fields:this.fields}})],1)},staticRenderFns:[]},g=n("VU/8")({name:"IngredientTable",data:function(){return{fields:[{key:"ingreName",label:"名稱"},{key:"ingreCount",label:"數量"},{key:"ingreUnit",label:"單位"},{key:"ingreTotalPrice",label:"總金額"}]}},props:["items","tableStyle"],methods:{isStyle:function(){return!!this.tableStyle}}},d,!1,null,null,null).exports,f={name:"InsertResume",data:function(){return{title:"新增食譜",form:{resumeName:"",ingredients:[{ingreName:"巧克力",ingreCount:"10",ingreUnit:"g",ingreTotalPrice:"200"}],resumeAmt:0},insertIngreForm:{ingreName:"",ingreCount:"",ingreUnit:"",ingreTotalPrice:""},insertFormOpts:[{value:"",text:"請選擇"},{value:"克",text:"克"},{value:"個",text:"個"}],show:!0,ingredient:{ingreName:"",ingreCount:"",ingreUnit:"",ingreTotalPrice:""}}},methods:{onSubmit:function(e){e.preventDefault(),alert(c()(this.form))},onReset:function(e){var t=this;e.preventDefault(),this.form.resumeName="",this.form.resumeAmt=0,this.form.ingredients=[],this.show=!1,this.$nextTick(function(){t.show=!0})},onIngredientAdd:function(e){this.$bvModal.show("insertIngredient")},resetInsertIngredientModal:function(){this.insertIngreForm.ingreName="",this.insertIngreForm.ingreCount="",this.insertIngreForm.ingreUnit="",this.insertIngreForm.ingreTotalPrice=""},handleInsertIngredientOk:function(e){e.preventDefault(),this.handleInsertIngredientSubmit()},handleInsertIngredientSubmit:function(){var e=this,t={ingreName:this.insertIngreForm.ingreName,ingreCount:this.insertIngreForm.ingreCount,ingreUnit:this.insertIngreForm.ingreUnit,ingreTotalPrice:this.insertIngreForm.ingreTotalPrice};this.validation(t)&&(this.form.ingredients.push(t),this.countTotalAmt(),this.resetInsertIngredientModal(),this.$nextTick(function(){e.$bvModal.hide("insertIngredient")}))},countTotalAmt:function(){var e=0;this.form.ingredients.forEach(function(t,n,r){e+=Number(t.ingreTotalPrice)}),console.log("total"+e),this.form.resumeAmt=e},validation:function(e){return!0}},components:{IngredientTable:g}},b={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"insertResume my-3"},[n("h1",[e._v(e._s(e.title))]),e._v(" "),e.show?n("b-form",{staticClass:"m-3",on:{submit:e.onSubmit,reset:e.onReset}},[n("b-form-group",{attrs:{id:"input-group-1",label:"食譜名稱：","label-cols":"4","label-cols-lg":"2","label-for":"resumeName"}},[n("b-form-input",{attrs:{id:"resumeName",type:"text",required:"",placeholder:"請輸入食譜名稱"},model:{value:e.form.resumeName,callback:function(t){e.$set(e.form,"resumeName",t)},expression:"form.resumeName"}})],1),e._v(" "),n("b-card",{staticClass:"my-3",attrs:{header:"食材們","no-body":""}},[n("ingredientTable",{attrs:{items:e.form.ingredients}}),e._v(" "),n("b-avatar",{staticClass:"mx-auto mb-3",attrs:{text:"+",button:"",variant:"primary"},on:{click:e.onIngredientAdd}})],1),e._v(" "),n("h2",[e._v(e._s(e.form.resumeAmt))]),e._v(" "),n("b-button",{attrs:{type:"submit",variant:"primary"}},[e._v("送出")]),e._v(" "),n("b-button",{attrs:{type:"reset",variant:"danger"}},[e._v("清除")])],1):e._e(),e._v(" "),n("router-link",{attrs:{to:{name:"SiteMap"}}},[e._v("返回")]),e._v(" "),n("b-modal",{attrs:{id:"insertIngredient",centered:"",title:"新增食材"},on:{show:e.resetInsertIngredientModal,hidden:e.resetInsertIngredientModal,ok:e.handleInsertIngredientOk}},[n("form",{on:{submit:function(t){return t.stopPropagation(),t.preventDefault(),e.handleInsertIngredientSubmit(t)}}},[n("b-form-group",{attrs:{label:"名稱","label-for":"ingreName","invalid-feedback":"請輸入名稱"}},[n("b-form-input",{attrs:{id:"ingreName",required:""},model:{value:e.insertIngreForm.ingreName,callback:function(t){e.$set(e.insertIngreForm,"ingreName",t)},expression:"insertIngreForm.ingreName"}})],1),e._v(" "),n("b-form-group",{attrs:{label:"數量","label-for":"ingreCount","invalid-feedback":"請輸入數量"}},[n("b-form-input",{attrs:{id:"ingreCount",required:""},model:{value:e.insertIngreForm.ingreCount,callback:function(t){e.$set(e.insertIngreForm,"ingreCount",t)},expression:"insertIngreForm.ingreCount"}})],1),e._v(" "),n("b-form-group",{attrs:{label:"單位","label-for":"ingreUnit","invalid-feedback":"請輸入單位"}},[n("b-form-select",{attrs:{id:"ingreUnit",options:e.insertFormOpts},model:{value:e.insertIngreForm.ingreUnit,callback:function(t){e.$set(e.insertIngreForm,"ingreUnit",t)},expression:"insertIngreForm.ingreUnit"}})],1),e._v(" "),n("b-form-group",{attrs:{label:"總價","label-for":"ingreTotalPrice","invalid-feedback":"請輸入總價"}},[n("b-form-input",{attrs:{id:"ingreTotalPrice",required:""},model:{value:e.insertIngreForm.ingreTotalPrice,callback:function(t){e.$set(e.insertIngreForm,"ingreTotalPrice",t)},expression:"insertIngreForm.ingreTotalPrice"}})],1)],1)])],1)},staticRenderFns:[]};var h=n("VU/8")(f,b,!1,function(e){n("9sE3")},"data-v-1d1063c5",null).exports,p={name:"ReadResume",data:function(){return{title:"食譜總覽",ingredients:[{ingreName:"巧克力",ingreCount:"10",ingreUnit:"g",ingreTotalPrice:"200"}],resume:{resumeName:"123",ingredients:[{ingreName:"巧克力",ingreCount:"10",ingreUnit:"g",ingreTotalPrice:"200"}],resumeAmt:0}}},components:{IngredientTable:g},methods:{getRecipes:function(){this.axios.get("http://localhost:8080/recipe").then(function(e){console.log(e.data)})}}},v={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"readResume m-3"},[t("h1",[this._v(this._s(this.title))]),this._v(" "),t("IngredientTable",{attrs:{items:this.ingredients,tableStyle:1}}),this._v(" "),t("router-link",{attrs:{to:{name:"SiteMap"}}},[this._v("Back")])],1)},staticRenderFns:[]};var I=n("VU/8")(p,v,!1,function(e){n("gG0b")},"data-v-4f960b16",null).exports;r.default.use(a.a);var _=new a.a({routes:[{path:"/",name:"SiteMap",component:u},{path:"/InsertResume",name:"InsertResume",component:h},{path:"/ReadResume",name:"ReadResume",component:I}]}),F=n("Tqaz"),T=(n("Jmt5"),n("9M+g"),n("mtWM")),k=n.n(T);r.default.use(F.a),r.default.use(F.b),r.default.prototype.axios=k.a,r.default.config.productionTip=!1,new r.default({el:"#app",router:_,components:{App:s},template:"<App/>"})},gG0b:function(e,t){},gsu9:function(e,t){},kFIL:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.a36e9abe88976c1a6cd5.js.map