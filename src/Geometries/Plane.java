package Geometries;
import Primitives.*;

import java.util.ArrayList;
import java.util.List;
/*

public class Plane extends Geometry implements FlatGeometry {

    private Vector _normal;
    private Point3D _Q;

    public Plane(){

        this._normal=new Vector();
        this._Q=new Point3D();

    }
    public Plane (Plane plane){
        this._normal=new Vector(plane._normal);
        this._Q=new Point3D(plane._Q);
        this._normal.normalize();
    }
    public Plane (Vector normal, Point3D q) {
        this._normal=new Vector(normal);
        this._normal.normalize();
        this._Q=new Point3D(q);
    }
    @Override
    public Vector getNormal(Point3D point){

        return new Vector(_normal);
    }
    public Point3D getQ(){

        return new Point3D(_Q);
    }
    public void setNormal(Vector normal){

        this._normal=normal;
        this._normal.normalize();
    }
    public void setQ(Point3D d){

        this._Q=d;
    }
    public List<Point3D> FindIntersections(Ray ray){
        List<Point3D>intersectionPoint=new ArrayList<Point3D>(1);
        Point3D P=new Point3D();
        Point3D P0=new Point3D(ray.get_POO());
        Vector V=new Vector(ray.get_direction());

        Point3D Q0=this.getQ();
        Vector N=this.getNormal(null);


        Vector vector=new Vector(Q0,P0);
        double t=(N.dotProduct(vector)*-1)/N.dotProduct(V);
        if(t>=0){
            V.scale(t);
            P.add(V);
//            vector.add(V);
            intersectionPoint.add(P);
        }
        return intersectionPoint;
    }

}
*/

public class Plane extends Geometry implements FlatGeometry {

    private Vector _normal;
    private Point3D _Q;

    // ***************** Constructors ********************** //

    public Plane(){
        _normal = new Vector();
        _Q = new Point3D();
    }

    public Plane (Plane plane){
        _normal = plane.getNormal(null);
        _Q = plane.getQ();
    }

    public Plane (Vector normal, Point3D q){
        _normal = new Vector(normal);
        _normal.normalize();
        _Q = new Point3D(q);
    }

    // ***************** Getters/Setters ********************** //

    public Vector getNormal(Point3D point) { return new Vector(_normal); }
    public Point3D getQ()                  { return new Point3D(_Q);	 }

    public void setNormal(Vector normal) {	this._normal = new Vector(normal); }
    public void setQ(Point3D d)          { this._Q = new Point3D(d);           }

    // ***************** Operations ******************** //

    @Override
    public List<Point3D> FindIntersections(Ray ray) {

        List<Point3D> intersectionPoint = new ArrayList<Point3D>(1);

        Point3D P0 = ray.get_POO();
        Point3D Q0 = this.getQ();
        Vector N = this.getNormal(null);
        Vector V = ray.get_direction();

        Vector v = new Vector (Q0, P0);
        double t = (N.dotProduct(v) * -1) / N.dotProduct(V);

        if (t >= 0){
            V.scale(t);
            P0.add(V);
            intersectionPoint.add(P0);
        }

        return intersectionPoint;

    }



}
