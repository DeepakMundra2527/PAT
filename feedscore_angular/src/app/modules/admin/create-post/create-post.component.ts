import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { StorageService } from '../../../auth/services/storage/storage.service';
import { AdminService } from '../services/admin.service';


@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrl: './create-post.component.scss'
})
export class CreatePostComponent {

  taskForm!: FormGroup;
  selectedFile!: File;
  imagePreview!: any;

  constructor(private adminService: AdminService,
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private router: Router){
    this.taskForm = this.fb.group({
      title: [' ', [Validators.required]],
      description: [' ', [Validators.required]],
    })
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
    this.previewImage();
  }

  previewImage() {
    const reader = new FileReader();
    reader.onload = () => {
      this.imagePreview = reader.result;
    }
    reader.readAsDataURL(this.selectedFile);
  }

  post() {
    const formData = {
      ...this.taskForm.value,
      userId:StorageService.getUserId(),
      'image': this.imagePreview?.split(',')[1] 
    };
  
    console.log(formData);
    console.log(StorageService.getUserId());
  
    this.adminService.post(formData).subscribe((res: any) => {
      if (res.id != null) {
        this.snackBar.open("Post created successfully", "Close", { duration: 5000 });
        this.router.navigateByUrl("/admin/dashboard");
      } else {
        this.snackBar.open("Something went wrong", "ERROR", { duration: 5000 });
      }
    });
  }
  
}
