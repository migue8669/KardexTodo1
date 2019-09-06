import { Injectable } from '@angular/core';
import { newUsuarioData, Usuario } from 'src/app/core/models/index.model';
import { Observable } from 'rxjs';
import { UserService } from '../../services/Usuario/User.service';

@Injectable({
  providedIn: 'root'
})
export class ProductUseCaseService {

  constructor(private usuarioService: UserService) {}

  postUserservice(Usuario: newUsuarioData): Observable<newUsuarioData> {
    return this.usuarioService.saveNewUser(Usuario);
  }
  getAllUsuarioService(): Observable<Usuario[]> {
    return this.usuarioService.getAllUser();
  }
}
