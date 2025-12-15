package app.resource;

import java.util.List;

import app.Model.StudentModel;
import app.Student.StudentEntity;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * REST API for Student CRUD operations
 */
@Path("/api/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentManagerApi {

    private final StudentModel model = new StudentModel();

    // ===================== READ ALL =====================
    @GET
    @Path("/all")
    public Response getAllStudents() {
        List<StudentEntity> list = model.getAllStudents();
        return Response.ok(list).build();
    }

    // ===================== READ ONE =====================
    @GET
    @Path("/{rollno}")
    public Response getStudent(@PathParam("rollno") int rollno) {
        StudentEntity s = model.getStudent(rollno);
        if (s == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(s).build();
    }

    // ===================== CREATE =====================
    @POST
    public Response createStudent(StudentResource r) {

        if (r == null || r.bday == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid input data")
                    .build();
        }

        StudentEntity s = new StudentEntity();
        s.setRollno(r.rollno);
        s.setSname(r.sname);
        s.setGender(r.gender);
        s.setBday(r.bday);     
        s.setMarks(r.marks);
        s.setDeptno(r.deptno);

        model.addStudent(s);
        return Response.status(Response.Status.CREATED).entity(s).build();
    }

    // ===================== UPDATE =====================
    @PUT
    @Path("/{rollno}")
    public Response updateStudent(@PathParam("rollno") int rollno,
                                  StudentResource r) {

        if (r == null || r.bday == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid input data")
                    .build();
        }

        StudentEntity s = new StudentEntity();
        s.setRollno(rollno);
        s.setSname(r.sname);
        s.setGender(r.gender);
        s.setBday(r.bday);     // ✅ DIRECT
        s.setMarks(r.marks);
        s.setDeptno(r.deptno);

        model.updateStudent(s);
        return Response.ok(s).build();
    }

    // ===================== DELETE =====================
    @DELETE
    @Path("/{rollno}")
    public Response deleteStudent(@PathParam("rollno") int rollno) {
        model.deleteStudent(rollno);
        return Response.noContent().build();
    }
}
