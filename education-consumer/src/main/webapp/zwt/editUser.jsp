<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form id="userForm">
		<input type="hidden" name="userid" value="${users.userid}">
       <div class="form-group">
          <label class="control-label" for="ds_host">用户名:</label>
          <div>
             <input class="form-control" name="username" type="text" value="${users.username}" placeholder=""/>
          </div>
       <div class="form-group">
          <label class="control-label" for="ds_host">密码:</label>
          <div >
             <input class="form-control" name="userpassword" type="text" value="${users.userpassword}" placeholder=""/>
          </div>
       </div>
       <div class="form-group">
          <label class="control-label" for="ds_host">角色:</label>
          <div>
             <input class="form-control" name="powerid" type="text" value="${users.powerid}" placeholder=""/>
          </div>
       </div>
  </form>