<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>


<div class="main-content">
 <div class="breadcrumbs" id="breadcrumbs">
  <script type="text/javascript">
   try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
  </script>
  <ul class="breadcrumb">
   <li> <i class="icon-home home-icon"></i> <a href="#">Home</a> </li>
   <li> <a href="#">Tables</a> </li>
   <li class="active">Simple &amp; Dynamic</li>
  </ul>
  <!-- .breadcrumb -->
 </div>

 <div class="page-content">
  <div class="page-header">
   <h1> Tables <small> <i class="icon-double-angle-right">
   </i> Static &amp; Dynamic Tables </small> </h1>
  </div><!-- /.page-header -->

  <div class="row">
   <div class="col-xs-12">
    <!-- PAGE CONTENT BEGINS -->
    <table id="grid-table"></table>
    <div id="grid-pager"></div>
    <script type="text/javascript">
     var $path_base = ${ctx}"/parkingSpaceManager/parkingSpace/manage";//this will be used in gritter alerts containing images
    </script>
    <!-- PAGE CONTENT ENDS -->
   </div><!-- /.col -->
  </div><!-- /.row -->
 </div><!-- /.page-content -->
 </div>

<div class="ace-settings-container" id="ace-settings-container">
 <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
  <i class="icon-cog bigger-150"></i>
 </div>

 <div class="ace-settings-box" id="ace-settings-box">
  <div>
   <div class="pull-left">
    <select id="skin-colorpicker" class="hide">
     <option data-skin="default" value="#438EB9">#438EB9</option>
     <option data-skin="skin-1" value="#222A2D">#222A2D</option>
     <option data-skin="skin-2" value="#C6487E">#C6487E</option>
     <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
    </select>
   </div>
   <span>&nbsp; Choose Skin</span>
  </div>

  <div>
   <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
   <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
  </div>

  <div>
   <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
   <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
  </div>

  <div>
   <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
   <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
  </div>

  <div>
   <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
   <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
  </div>

  <div>
   <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
   <label class="lbl" for="ace-settings-add-container">
    Inside
    <b>.container</b>
   </label>
  </div>
 </div>
</div><!-- /#ace-settings-container -->

<script src="${ctx}/static/js/typeahead-bs2.min.js"></script>
<script src="${ctx}/static/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${ctx}/static/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="${ctx}/static/js/jqGrid/i18n/grid.locale-en.js"></script>
<script src="${ctx}/static/js/ace-elements.min.js"></script>

<script type="text/javascript">

    var selId ;
    var grid_data = ${list};

    var rowData = $('#grid-table').jqGrid('getRowData',selId);

    jQuery(function($) {
        var grid_selector = "#grid-table";
        var pager_selector = "#grid-pager";

        jQuery(grid_selector).jqGrid({
            //direction: "rtl",
            data: grid_data,
            datatype: "local",
            height: 'auto',
            colNames:[' ', '编号','车位号','车牌号', '状态', '开始时间', '结束时间','应付金额'],
            colModel:[
                {name:'myac',index:'', width:80, fixed:true, sortable:false, resize:false,
                    formatter:'actions',
                    formatoptions:{
                        keys:true,
                        delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback},
                       // editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
                    }
                },
                {name:'id',index:'id', width:60, edittype:"textarea", editable: true},
                {name:'spaceNumber',index:'spaceNumber', width:90, edittype:"textarea", editable: true},
                {name:'carNumber',index:'carNumber', width:150, edittype:"textarea", editable: true},
                {name:'status',index:'status', width:70, edittype:"textarea", editable: true},
                {name:'startTime',index:'startTime', width:90, edittype:"textarea", editable: true},
                {name:'endTime',index:'endTime', width:90, edittype:"textarea", editable: true},
                {name:'cost',index:'cost', width:60, edittype:"textarea", editable: true}
              //{name:'sdate',index:'sdate',width:90, editable:true, sorttype:"date",unformat: pickDate},
             // {name:'name',index:'name', width:150,editable: true,editoptions:{size:"20",maxlength:"30"}},
             // {name:'stock',index:'stock', width:70, editable: true,edittype:"checkbox",editoptions: {value:"Yes:No"},unformat: aceSwitch},
             // {name:'ship',index:'ship', width:90, editable: true,edittype:"select",editoptions:{value:"FE:FedEx;IN:InTime;TN:TNT;AR:ARAMEX"}},
            //  {name:'note',index:'note', width:150, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}}
            ],

            viewrecords : true,
            rowNum:10,
            rowList:[10,20,30],
            pager : pager_selector,
            altRows: true,
            //toppager: true,

            multiselect: true,
            //multikey: "ctrlKey",
            // multiboxonly: true,

            onSelectRow: function (rowid, status) {
                selId = rowid;　　//给最外层的selId赋值
            },

            loadComplete : function() {
                var table = this;
                setTimeout(function(){
                    styleCheckbox(table);
                    updateActionIcons(table);
                    updatePagerIcons(table);
                    enableTooltips(table);
                }, 0);
            },

            editurl: $path_base+"?selId=178",//nothing is saved
            caption: "jqGrid with inline editing",
            autowidth: true
        });

        //enable search/filter toolbar
        //jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})

        //switch element when editing inline
        function aceSwitch( cellvalue, options, cell ) {
            setTimeout(function(){
                $(cell) .find('input[type=checkbox]')
                        .wrap('<label class="inline" />')
                        .addClass('ace ace-switch ace-switch-5')
                        .after('<span class="lbl"></span>');
            }, 0);
        }
        //enable datepicker
        function pickDate( cellvalue, options, cell ) {
            setTimeout(function(){
                $(cell) .find('input[type=text]')
                        .datepicker({format:'yyyy-mm-dd' , autoclose:true});
            }, 0);
        }


        //navButtons
        jQuery(grid_selector).jqGrid('navGrid',pager_selector, {
                    edit: true,
                    editicon : 'icon-pencil blue',
                    add: true,
                    addicon : 'icon-plus-sign purple',
                    del: true,
                    delicon : 'icon-trash red',
                    search: true,
                    searchicon : 'icon-search orange',
                    refresh: true,
                    refreshicon : 'icon-refresh green',
                    view: true,
                    viewicon : 'icon-zoom-in grey',
                },
                {
                  //edit record form
                  //closeAfterEdit: true,
                    recreateForm: true,
                    beforeShowForm : function(e) {
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                        style_edit_form(form);
                    }
                },
                {
                 //new record form
                   closeAfterAdd: true,
                   recreateForm: true,
                   viewPagerButtons: false,
                   beforeShowForm : function(e) {
                       var form = $(e[0]);
                       form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                       style_edit_form(form);
                   }
                },
                {
                 //delete record form
                   recreateForm: true,
                   beforeShowForm : function(e) {
                       var form = $(e[0]);
                       if(form.data('styled')) return false;

                       form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                       style_delete_form(form);
                       form.data('styled', true);
                   },
                    onClick : function(e) {
                        alert(1);
                    }
                },
                {
                  //search form
                    recreateForm: true,
                    afterShowSearch: function(e){
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                        style_search_form(form);
                    },
                    afterRedraw: function(){
                        style_search_filters($(this));
                    },
                    multipleSearch: true,
                   /**
                    * multipleGroup:true,
                    * showQuery: true
                    */
                },
                {
                  //view record form
                    recreateForm: true,
                    beforeShowForm: function(e){
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                    }
                })

        function style_edit_form(form) {
            //enable datepicker on "sdate" field and switches for "stock" field
            form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
                    .end().find('input[name=stock]')
                    .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
            //update buttons classes
            var buttons = form.next().find('.EditButton .fm-button');
            buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
            buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
            buttons.eq(1).prepend('<i class="icon-remove"></i>')

            buttons = form.next().find('.navButton a');
            buttons.find('.ui-icon').remove();
            buttons.eq(0).append('<i class="icon-chevron-left"></i>');
            buttons.eq(1).append('<i class="icon-chevron-right"></i>');
        }

        function style_delete_form(form) {
            var buttons = form.next().find('.EditButton .fm-button');
            buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
            buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
            buttons.eq(1).prepend('<i class="icon-remove"></i>')
        }

        function style_search_filters(form) {
            form.find('.delete-rule').val('X');
            form.find('.add-rule').addClass('btn btn-xs btn-primary');
            form.find('.add-group').addClass('btn btn-xs btn-success');
            form.find('.delete-group').addClass('btn btn-xs btn-danger');
        }

        function style_search_form(form) {
            var dialog = form.closest('.ui-jqdialog');
            var buttons = dialog.find('.EditTable')
            buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
            buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
            buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
        }

        function beforeDeleteCallback(e) {
            var form = $(e[0]);
            if(form.data('styled')) return false;

            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
            style_delete_form(form);

            form.data('styled', true);
        }

        function beforeEditCallback(e) {
            var form = $(e[0]);
            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
            style_edit_form(form);
        }

        //replace icons with FontAwesome icons like above
        function updatePagerIcons(table) {
            var replacement =
            {
                'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
                'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
                'ui-icon-seek-next' : 'icon-angle-right bigger-140',
                'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
            };
            $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
                var icon = $(this);
                var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

                if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
            })
        }

        function enableTooltips(table) {
            $('.navtable .ui-pg-button').tooltip({container:'body'});
            $(table).find('.ui-pg-div').tooltip({container:'body'});
        }

        //var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');

    });
</script>