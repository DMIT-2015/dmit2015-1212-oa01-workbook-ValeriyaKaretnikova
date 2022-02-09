package dmit2015.resource;

import common.validator.BeanValidator;
import dmit2015.entity.TodoItem;
import dmit2015.repository.TodoItemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

@ApplicationScoped
@Path("TodoItems")                    // All methods of this class are associated this URL path
@Consumes(MediaType.APPLICATION_JSON)    // All methods this class accept only JSON format data
@Produces(MediaType.APPLICATION_JSON)    // All methods returns data that has been converted to JSON format
public class TodoItemResource {

    @Inject
    private TodoItemRepository _todoItemRepository;

    @GET    // This method only accepts HTTP GET requests.
    public Response listTodoItems() {
        return Response.ok(_todoItemRepository.list()).build();
    }

    @Path("{id}")
    @GET    // This method only accepts HTTP GET requests.
    public Response findTodoItemById(@PathParam("id") Long todoItemId) {
        TodoItem existingTodoItem = _todoItemRepository.findOptional(todoItemId).orElseThrow(NotFoundException::new);

        return Response.ok(existingTodoItem).build();
    }

    @POST    // This method only accepts HTTP POST requests.
    public Response addTodoItem(TodoItem newTodoItem, @Context UriInfo uriInfo) {

        String errorMessage = BeanValidator.validateBean(TodoItem.class, newTodoItem);
        if (errorMessage != null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(errorMessage)
                    .build();
        }

        try {
            // Persist the new TodoItem into the database
            _todoItemRepository.create(newTodoItem);
        } catch (Exception ex) {
            // Return a HTTP status of "500 Internal Server Error" containing the exception message
            return Response.
                    serverError()
                    .entity(ex.getMessage())
                    .build();
        }

        // userInfo is injected via @Context parameter to this method
        URI location = uriInfo.getAbsolutePathBuilder()
                .path(newTodoItem.getId() + "")
                .build();

        // Set the location path of the new entity with its identifier
        // Returns an HTTP status of "201 Created" if the TodoItem was successfully persisted
        return Response
                .created(location)
                .build();
    }

    @PUT            // This method only accepts HTTP PUT requests.
    @Path("{id}")    // This method accepts a path parameter and gives it a name of id
    public Response updateTodoItem(@PathParam("id") Long todoItemId, TodoItem updatedTodoItem) {
        if (!todoItemId.equals(updatedTodoItem.getId())) {
            throw new BadRequestException();
        }

        _todoItemRepository.findOptional(todoItemId).orElseThrow(NotFoundException::new);

        String errorMessage = BeanValidator.validateBean(TodoItem.class, updatedTodoItem);
        if (errorMessage != null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(errorMessage)
                    .build();
        }

        try {
            _todoItemRepository.update(updatedTodoItem);
        } catch (Exception ex) {
            // Return an HTTP status of "500 Internal Server Error" containing the exception message
            return Response.
                    serverError()
                    .entity(ex.getMessage())
                    .build();
        }

        // Returns an HTTP status "204 No Content" if the TodoItem was successfully persisted
        return Response.noContent().build();
    }

    @DELETE            // This method only accepts HTTP DELETE requests.
    @Path("{id}")    // This method accepts a path parameter and gives it a name of id
    public Response delete(@PathParam("id") Long todoItemId) {

        _todoItemRepository.findOptional(todoItemId).orElseThrow(NotFoundException::new);

        try {
            _todoItemRepository.delete(todoItemId);    // Removes the TodoItem from being persisted
        } catch (Exception ex) {
            // Return a HTTP status of "500 Internal Server Error" containing the exception message
            return Response
                    .serverError()
                    .encoding(ex.getMessage())
                    .build();
        }

        // Returns an HTTP status "204 No Content" if the TodoItem was successfully deleted
        return Response.noContent().build();
    }

}