import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {
    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): boolean {
        const expectedRoleArray = route.data.expectedRole;
        const userDetail = JSON.parse(localStorage.getItem('user'));
        let expectedRole;
        for (const index in expectedRoleArray) {
            if (expectedRoleArray[index] === userDetail.role) {
                expectedRole = expectedRoleArray[index];
            }
        }

        if (userDetail && userDetail.role === expectedRole) {
            return true;
        } else {
            return false;
        }
    }

}
