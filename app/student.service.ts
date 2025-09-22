import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student.model';  // Import the Student interface

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  API = "http://localhost:8083/student";  // Update to match the backend port

  constructor(private http: HttpClient) { }

  // Register a new student
  public registerStudent(studentData: Student): Observable<Student> {
    return this.http.post<Student>(this.API, studentData);
  }

  // Fetch all students
  public getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.API);
  }

  // Delete student by ID
  public deleteStudent(studentId: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${studentId}`);
  }

  // Update student details
  public updateStudent(student: Student): Observable<Student> {
    return this.http.put<Student>(`${this.API}/${student.id}`, student);
  }
}
