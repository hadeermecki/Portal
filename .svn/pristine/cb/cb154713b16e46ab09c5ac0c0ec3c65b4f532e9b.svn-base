package com.cit.vericash.common.data.logging.persist;

import com.cit.vericash.data.logging.dto.Query;
import  com.cit.vericash.data.logging.dto.Response;
import com.cit.vericash.data.logging.dto.Query.Type;
import com.cit.vericash.data.logging.dto.Record;
import com.cit.vericash.data.logging.model.IBaseModel;
import com.cit.vericash.data.logging.model.common.CommissionExecutionSummary;
import com.google.gson.Gson;
/*import com.vericash.request.dto.Response;
import com.vericash.request.dto.Response.Status;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DaoService {

	@Autowired
	IGenericDao<IBaseModel> dao;

	@RequestMapping(value = "logging_dao_service/query/execute", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Response executeQuery(@RequestBody Query query) {
		System.out.println("Persist: received "+query.getType());
		Response response = new Response() ;
		System.out.println(query.getType());
		if (query.getType() != Type.SELECT) // JPA CRUD Operations
		{
			Class<?> clazz = null;
			IBaseModel ibaseModel=null;
			Gson gson = new Gson();
			if(query.getEntityModelClassPath()!=null)
			{
				try {
					clazz = Class.forName(query.getEntityModelClassPath());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				ibaseModel = (IBaseModel) gson.fromJson(query.getQueryObject(), clazz);
			}
			if (query.getType() == Type.INSERT) {
				dao.create(ibaseModel);
			} else if (query.getType() == Type.UPDATE) {
				dao.update(ibaseModel);

			} else if(query.getType() == Type.UPDATE_NATIVE) {
				System.out.println(query.getQueryObject());
				dao.updateNativeQuery(query.getQueryObject());

			}else if (query.getType() == Type.DELETE) {
				dao.delete(query.getQueryObject());
			}

		}
		response.setStatus(Response.Status.SUCCESS);
        System.out.println(response.getResult());
		return response;
	}

}
