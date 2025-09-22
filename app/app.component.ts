import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StudentService } from './student.service';
import { Student } from './student.model';

declare var bootstrap: any;  // Ensure Bootstrap is available

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'student-module';

  studentDetails: Student[] = [];

  studentToUpdate: Student = {
    id: null,
    name: "",
    email: "",
    degree: "",
    graduationYear: null
  };

  constructor(private studentService: StudentService) {
    this.getStudentDetails();
  }

  // Register new student
  register(registerForm: NgForm) {
    if (registerForm.invalid || !registerForm.value.graduationYear) {
      console.error('Form is invalid or graduation year is missing');
      return;
    }

    this.studentService.registerStudent(registerForm.value).subscribe(
      (resp: Student) => {
        registerForm.reset();
        this.getStudentDetails();
      },
      (err: any) => {
        console.error('Error registering student', err);
      }
    );
  }

  // Fetch student details
  getStudentDetails() {
    this.studentService.getStudents().subscribe(
      (resp: Student[]) => {
        this.studentDetails = resp;
      },
      (err: any) => {
        console.error('Error fetching students', err);
      }
    );
  }

  // Delete student
  deleteStudent(student: Student) {
    if (student.id !== null) {
      this.studentService.deleteStudent(student.id).subscribe(
        () => this.getStudentDetails(),
        (err: any) => {
          console.error('Error deleting student', err);
        }
      );
    } else {
      console.error('Student ID is null, cannot delete');
    }
  }

  // Open modal with student data for editing
  edit(student: Student) {
    this.studentToUpdate = { ...student };

    const modalElement = document.getElementById('exampleModal');
    if (modalElement) {
      const modal = new bootstrap.Modal(modalElement);
      modal.show();
    }
  }

  // Update student and close modal
  updateStudent() {
    if (!this.studentToUpdate.name || !this.studentToUpdate.email || !this.studentToUpdate.degree || !this.studentToUpdate.graduationYear) {
      console.error('Missing required fields in student update');
      return;
    }

    this.studentService.updateStudent(this.studentToUpdate).subscribe(
      () => {
        this.getStudentDetails();
        this.closeModal();  // Close modal after update
      },
      (err: any) => {
        console.error('Error updating student', err);
      }
    );
  }

  // Close Bootstrap Modal
  closeModal() {
    const modalElement = document.getElementById('exampleModal');
    if (modalElement) {
      const modalInstance = bootstrap.Modal.getInstance(modalElement);
      if (modalInstance) modalInstance.hide();
    }
  }
}
